package com.example.yizhu.bitcoin_starter.utils;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.RegTestParams;

public class BitCoinJWallet {
    private ECKey myKey;
    private NetworkParameters netParams;

    public BitCoinJWallet(){
        netParams = RegTestParams.get();
    }

    // create key
    public void CreateMyAddress() {
        myKey = new ECKey();
    }

    // get my address
    public String getMyAddress(){
        if (myKey != null) {
            Address addressFromKey = myKey.toAddress(netParams);
            return addressFromKey.toString();
        }
        else {
            return "";
        }
    }

    // get private key
    public String getMyPrivateKey() {
        if (myKey != null) {
            return myKey.getPrivKey().toString();
        }
        else {
            return "";
        }
    }
}
