package by.gritsuk.dima.util;

import by.gritsuk.dima.domain.Client;
import by.gritsuk.dima.domain.ClientBet;
import by.gritsuk.dima.service.ServiceFactory;
import by.gritsuk.dima.service.UserService;
import by.gritsuk.dima.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class IncomeSender {
    private static final Logger LOGGER= LogManager.getLogger(PaymentThread.class);
    private List<ClientBet> bets;

    public IncomeSender(List<ClientBet> bets){
        this.bets=bets;
    }

    public void sendIncome() {
        UserService userService= ServiceFactory.getInstance().getUserService();
        for(ClientBet bet:bets) {
            try {
                if(bet.getStatus().equals("win")) {
                    Client client = (Client) userService.getById(bet.getUserId());
                    userService.updateCash(client.getClientAccountId(), client.getCash()+bet.getIncome());
                }
                else if(bet.getStatus().equals("return")){
                    Client client = (Client) userService.getById(bet.getUserId());
                    userService.updateCash(client.getClientAccountId(), client.getCash()+bet.getDeposit());
                }
            } catch (ServiceException e) {
                LOGGER.error("Couldn't set income for user with id="+bet.getUserId());
            }
        }
    }
}
