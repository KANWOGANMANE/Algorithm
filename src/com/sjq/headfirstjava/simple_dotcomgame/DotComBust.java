package com.sjq.headfirstjava.simple_dotcomgame;

import java.util.ArrayList;

public class DotComBust {
    private GameHelper gamehelper = new GameHelper();
    private ArrayList docComList =  new ArrayList();
    private int numOfGuesses = 0;

    public void setUpGame(){
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();
        one.setName("alibaba.com");
        two.setName("tencent.com");
        three.setName("netyi.com");
        docComList.add(one);
        docComList.add(two);
        docComList.add(three);


    }



}
