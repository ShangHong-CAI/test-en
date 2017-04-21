/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

import test_en.RuleBasedPosTagger;

/**
 *
 * @author 尚宏
 */
public class POS_russian implements PosterNLPSegImpl {

    @Override
    public String[] getStringToken(String str) throws PosterNLPException {
        try {
            String[] input_array = str.split(" ");
            RuleBasedPosTagger tagger = new RuleBasedPosTagger();
            for (int i = 0; i < input_array.length; i++) {
                RuleBasedPosTagger.PosTag tag = tagger.posTag(input_array[i]);
                System.out.println(input_array[i] + " : " + tag.toString());
            }
            return input_array;
        } catch (Exception e) {
            throw new PosterNLPException("POS_russian:" + e.getMessage());
        }
    }

}
