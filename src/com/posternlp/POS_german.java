/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 尚宏
 */
public class POS_german implements PosterNLPSegImpl {

    private static String models_path = "model/";
    private static String model_german = "german-fast.tagger";
    private static MaxentTagger tagger = new MaxentTagger(models_path + model_german);
    private static TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                    "untokenizable=noneKeep");
    @Override
    public String[] getStringToken(String str) throws PosterNLPException {
        try {
            

            InputStream is = new ByteArrayInputStream(str.getBytes());
            BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

            DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
            documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);

            int word_number = 0;
            ArrayList<String> output_text_list = new ArrayList<String>();

            for (List<HasWord> sentence : documentPreprocessor) {
                List<TaggedWord> tSentence = tagger.tagSentence(sentence);
                for (TaggedWord tw : tSentence) {
                    word_number++;
                    output_text_list.add(tw.word());
                    //System.out.println(tw.word());
                }

            //System.out.println(SentenceUtils.listToString(tSentence, false));
                //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
            }
            String[] output_text_array = new String[word_number];
            output_text_list.toArray(output_text_array);

            return output_text_array;
        } catch (Exception e) {
            throw new PosterNLPException("POS_german:" + e.getMessage());
        }

    }

}
