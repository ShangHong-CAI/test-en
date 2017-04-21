/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

import java.util.ArrayList;
import java.util.List;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

/**
 *
 * @author 尚宏
 */
public class POS_korea implements PosterNLPSegImpl {

    @Override
    public String[] getStringToken(String str) throws PosterNLPException {
        try {
            int word_number = 0;
            //corpus_build에 있는 데이터로부터 models 생성
//            kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder builder = new kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder();
//            builder.buildPath("corpus_build");
//            builder.save("models");

            //생성된 models를 이용하여 객체 생성
            Komoran komoran = new Komoran("models");
            //사용자 사전 추가
            komoran.setUserDic("user_data/dic.user");
            ArrayList<String> output_text_list = new ArrayList<String>();
            String in = str;

            List<List<Pair<String, String>>> analyzeResultList = komoran.analyze(in);
            for (List<Pair<String, String>> wordResultList : analyzeResultList) {
                for (int i = 0; i < wordResultList.size(); i++) {
                    word_number++;
                    Pair<String, String> pair = wordResultList.get(i);
                    output_text_list.add(pair.getFirst());
                    //System.out.println(pair.getFirst()+"/"+pair.getSecond());
                    //System.out.println(pair.getFirst());
                    if (i != wordResultList.size() - 1) {
                        //System.out.println("+");
                    }
                }
                //System.out.println();
            }

            String[] output_text_array = new String[word_number];
            output_text_list.toArray(output_text_array);

            return output_text_array;
        } catch (Exception e) {
            throw new PosterNLPException("POS_korea:" + e.getMessage());
        }
    }

}
