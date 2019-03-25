package by.gritsuk.dima.util;

import by.gritsuk.dima.domain.ClientBet;

import java.util.ArrayList;
import java.util.List;

public class TempBetList {
    private List<ClientBet>bets;

    public TempBetList(){
        bets=new ArrayList<>();
    }

    public List<ClientBet> getBets() {
        return bets;
    }

    public void setBets(List<ClientBet> bets) {
        this.bets = bets;
    }
}
