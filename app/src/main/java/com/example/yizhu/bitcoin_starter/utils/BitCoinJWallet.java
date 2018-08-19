package com.example.yizhu.bitcoin_starter.utils;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.kits.WalletAppKit;
import org.bitcoinj.params.RegTestParams;

public class BitCoinJWallet {
    private ECKey myKey;
    private ECKey forwardKey;
    private NetworkParameters netParams;

    public BitCoinJWallet(){
        netParams = RegTestParams.get();
    }

    public void CreateMyAddress() {
        myKey = new ECKey();
    }

    public String getMyAddress(){
        if (myKey != null) {
            Address addressFromKey = myKey.toAddress(netParams);
            return addressFromKey.toString();
        }
        else {
            return "";
        }
    }

    public String getMyPrivateKey() {
        if (myKey != null) {
            return myKey.getPrivKey().toString();
        }
        else {
            return "";
        }

    }
}
