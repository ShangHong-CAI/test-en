/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

import java.util.ArrayList;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

/**
 *
 * @author 尚宏
 */
public class POS_japan implements PosterNLPSegImpl {
    private static Tokenizer tokenizer = Tokenizer.builder().build();
    @Override
    public String[] getStringToken(String str) throws PosterNLPException {
        try {
            int word_number = 0;
            ArrayList<String> output_text_list = new ArrayList<String>();            
            for (Token token : tokenizer.tokenize(str)) {
                word_number = word_number + 1;
                output_text_list.add(token.getSurfaceForm());
            //output_text += token.getSurfaceForm() + "\t" + token.getAllFeatures()+"\n";
                //System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
            }
            String[] output_text_array = new String[word_number];
            output_text_list.toArray(output_text_array);

            return output_text_array;
        } catch (Exception e) {
            throw new PosterNLPException("POS_japan" + e.getMessage());
        }
    }

}
