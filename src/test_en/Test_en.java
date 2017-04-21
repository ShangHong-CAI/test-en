/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_en;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
//For japan (kuromoji-0.7.7.jar)
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

import java.util.ArrayList;
import java.util.List;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

/**
 *
 * @author tfcs
 */
public class Test_en {

    //把這個路徑換成models的路徑
    //static String models_path = "";
    static String models_path = "model/";
    
    static String model_arabic = "arabic.tagger";
    static String model_english = "english-caseless-left3words-distsim.tagger";
    static String model_spanish = "spanish-distsim.tagger";
    static String model_french = "french.tagger";
    static String model_german = "german-fast.tagger";  

    public static String[] POS_arabic(String input_text) throws UnsupportedEncodingException
    {
        MaxentTagger tagger = new MaxentTagger(models_path+model_arabic);
        TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                                                                               "untokenizable=noneKeep");

        InputStream is = new ByteArrayInputStream(input_text.getBytes());
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
        documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);
        
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        for (List<HasWord> sentence : documentPreprocessor) 
        {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for (TaggedWord tw : tSentence) 
            {
                word_number++;
                output_text_list.add(tw.word());
                //System.out.println(tw.word());
            }
            
            //System.out.println(SentenceUtils.listToString(tSentence, false));
            //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }
    
    
    public static String[] POS_english(String input_text) throws UnsupportedEncodingException
    {
        MaxentTagger tagger = new MaxentTagger(models_path + model_english);
        TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                                                                               "untokenizable=noneKeep");

        InputStream is = new ByteArrayInputStream(input_text.getBytes());
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
        documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);
        
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        for (List<HasWord> sentence : documentPreprocessor) 
        {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for (TaggedWord tw : tSentence) 
            {
                word_number++;
                output_text_list.add(tw.word());
                //System.out.println(tw.word());
            }
            
            //System.out.println(SentenceUtils.listToString(tSentence, false));
            //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }
    
    
    public static String[] POS_spanish(String input_text) throws UnsupportedEncodingException
    {
        MaxentTagger tagger = new MaxentTagger(models_path + model_spanish);
        TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                                                                               "untokenizable=noneKeep");

        InputStream is = new ByteArrayInputStream(input_text.getBytes());
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
        documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);
        
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        for (List<HasWord> sentence : documentPreprocessor) 
        {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for (TaggedWord tw : tSentence) 
            {
                word_number++;
                output_text_list.add(tw.word());
                //System.out.println(tw.word());
            }
            
            //System.out.println(SentenceUtils.listToString(tSentence, false));
            //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }
    
    
    public static String[] POS_french(String input_text) throws UnsupportedEncodingException
    {
        MaxentTagger tagger = new MaxentTagger(models_path + model_french);
        TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                                                                               "untokenizable=noneKeep");

        InputStream is = new ByteArrayInputStream(input_text.getBytes());
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
        documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);
        
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        for (List<HasWord> sentence : documentPreprocessor) 
        {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for (TaggedWord tw : tSentence) 
            {
                word_number++;
                output_text_list.add(tw.word());
                //System.out.println(tw.word());
            }
            
            //System.out.println(SentenceUtils.listToString(tSentence, false));
            //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }
    
    
    public static String[] POS_german(String input_text) throws UnsupportedEncodingException
    {
        MaxentTagger tagger = new MaxentTagger(models_path + model_german);
        TokenizerFactory<CoreLabel> ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
                                                                               "untokenizable=noneKeep");

        InputStream is = new ByteArrayInputStream(input_text.getBytes());
        BufferedReader r = new BufferedReader(new InputStreamReader(is, "utf-8"));

        DocumentPreprocessor documentPreprocessor = new DocumentPreprocessor(r);
        documentPreprocessor.setTokenizerFactory(ptbTokenizerFactory);
        
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        for (List<HasWord> sentence : documentPreprocessor) 
        {
            List<TaggedWord> tSentence = tagger.tagSentence(sentence);
            for (TaggedWord tw : tSentence) 
            {
                word_number++;
                output_text_list.add(tw.word());
                //System.out.println(tw.word());
            }
            
            //System.out.println(SentenceUtils.listToString(tSentence, false));
            //out_text_array = SentenceUtils.listToString(tSentence, false).split(" ");
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }
    
    
    public static String[] POS_japan(String input_text)
    {
        int word_number = 0;
        ArrayList<String> output_text_list = new ArrayList<String>();
        
        Tokenizer tokenizer = Tokenizer.builder().build();
        for (Token token : tokenizer.tokenize(input_text)) 
        {
            word_number = word_number+1;
            output_text_list.add(token.getSurfaceForm());
            //output_text += token.getSurfaceForm() + "\t" + token.getAllFeatures()+"\n";
            //System.out.println(token.getSurfaceForm() + "\t" + token.getAllFeatures());
        }
        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);
        
        return output_text_array;
    }

    public static String[] POS_korea(String input_text)
    {
        int word_number = 0;
        //corpus_build에 있는 데이터로부터 models 생성
//        kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder builder = new kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder();
//        builder.buildPath("corpus_build");
//        builder.save("models");


        //생성된 models를 이용하여 객체 생성
        Komoran komoran = new Komoran("models");
        //사용자 사전 추가
        komoran.setUserDic("user_data/dic.user");
        ArrayList<String> output_text_list = new ArrayList<String>();
        String in = input_text;

        List<List<Pair<String, String>>> analyzeResultList = komoran.analyze(in);
        for (List<Pair<String, String>> wordResultList : analyzeResultList) 
        {
                for(int i=0;i<wordResultList.size();i++)
                {
                    word_number ++;
                    Pair<String, String> pair = wordResultList.get(i);
                    output_text_list.add(pair.getFirst());
                    //System.out.println(pair.getFirst()+"/"+pair.getSecond());
                    //System.out.println(pair.getFirst());
                    if(i != wordResultList.size()-1)
                    {
                            //System.out.println("+");
                    }
                }
                //System.out.println();
        }

        String [] output_text_array = new String[word_number];
        output_text_list.toArray(output_text_array);

        return output_text_array;
    }
    /**
     * @param args the command line arguments
     */
    
    public static String[] POS_russian(String input_text)
    {
        String [] input_array = input_text.split(" ");
        RuleBasedPosTagger tagger = new RuleBasedPosTagger();
        for(int i=0;i<input_array.length;i++)
        {
            RuleBasedPosTagger.PosTag tag = tagger.posTag(input_array[i]);
            System.out.println(input_array[i]+" : "+tag.toString());
        }
        return input_array;
    }
    
    public static void dump_array_date(String [] in_text_array)
    {
        for (String s : in_text_array) 
        {
            System.out.println(s);
        }  
    }
    
    public static void main(String[] args) throws UnsupportedEncodingException 
    {
        //顯示GUI
//        Form form1 = new Form();//開啟GUI
//        form1.InitializeComponent();
        
        
        String Input_text = "이 사과입니다";
        System.out.println("韓文測試: 輸入語句: "+Input_text+"\n");
        String [] output_text_array = POS_korea(Input_text);
        dump_array_date(output_text_array);
        

//        String input_text = "В результате крушения погибли командир отряда специального назначения при ГУВД Ростовской области полковник милиции Михаил Перов и предприниматель";
//        String [] input_array = input_text.split(" ");
//        RuleBasedPosTagger tagger = new RuleBasedPosTagger();
//        for(int i=0;i<input_array.length;i++)
//        {
//            RuleBasedPosTagger.PosTag tag = tagger.posTag(input_array[i]);
//            System.out.println(input_array[i]+" : "+tag.toString());
//        }
        //=======================================
        
//        System.out.println("=================================================\n");
//        String Input_text = "寿司が食べたい。";
//        System.out.println("日文測試: 輸入語句: "+Input_text+"\n");
//        String [] output_text_array = POS_japan(Input_text);
//        dump_array_date(output_text_array);
        
        // TODO code application logic here
        //================================================================
//        System.out.println("=================================================\n");
//        Input_text = "هذا هو التفاح،";
//        System.out.println("阿拉伯測試: 輸入語句: "+Input_text+"\n");
//        output_text_array = POS_arabic(Input_text);
//        dump_array_date(output_text_array);
        //================================================================
//        System.out.println("=================================================\n");
//        Input_text = "This is apple.";
//        System.out.println("英文測試: 輸入語句: "+Input_text+"\n");
//        output_text_array = POS_english(Input_text);
//        dump_array_date(output_text_array);
        //================================================================
//        System.out.println("=================================================\n");
//        Input_text = "Esta es una manzana";
//        System.out.println("西班牙測試: 輸入語句: "+Input_text+"\n");
//        output_text_array = POS_spanish(Input_text);
//        dump_array_date(output_text_array);
        //================================================================
//        System.out.println("=================================================\n");
//        Input_text = "Ceci est une pomme";
//        System.out.println("法文測試: 輸入語句: "+Input_text+"\n");
//        output_text_array = POS_french("هذا هو التفاح،");
//        dump_array_date(output_text_array);
        //================================================================
//        System.out.println("=================================================\n");
//        Input_text = "Dies ist ein Apfel";
//        System.out.println("德文測試: 輸入語句: "+Input_text+"\n");
//        output_text_array = POS_german(Input_text);
//        dump_array_date(output_text_array);
//        

    }
    
}
