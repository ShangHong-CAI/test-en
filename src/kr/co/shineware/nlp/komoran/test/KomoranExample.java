package kr.co.shineware.nlp.komoran.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder;
import kr.co.shineware.util.common.model.Pair;

public class KomoranExample {

        public static String[] POS_koran(String input_text)
        {
            int word_number = 0;
            //corpus_build에 있는 데이터로부터 models 생성
            ModelBuilder builder = new ModelBuilder();
            builder.buildPath("corpus_build");
            builder.save("models");


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
        
        public static void dump_array_date(String [] in_text_array)
        {
            
            for (String s : in_text_array) 
            {
                System.out.println(s);
            }  
        }
	public static void main(String[] args) {
		
	String Input_text = "이 사과입니다";
        System.out.println("韓文測試: 輸入語句: "+Input_text+"\n");
        String [] output_text_array = POS_koran(Input_text);
        POS_koran(Input_text);
        dump_array_date(output_text_array);
        /*
		//corpus_build에 있는 데이터로부터 models 생성
		ModelBuilder builder = new ModelBuilder();
		builder.buildPath("corpus_build");
		builder.save("models");
		
		
		//생성된 models를 이용하여 객체 생성
		Komoran komoran = new Komoran("models");
		//사용자 사전 추가
		komoran.setUserDic("user_data/dic.user");
		
		String in = "이 사과입니다";
		
		List<List<Pair<String, String>>> analyzeResultList = komoran.analyze(in);
		for (List<Pair<String, String>> wordResultList : analyzeResultList) {
			for(int i=0;i<wordResultList.size();i++){
				Pair<String, String> pair = wordResultList.get(i);
                                
				System.out.println(pair.getFirst()+"/"+pair.getSecond());
				if(i != wordResultList.size()-1){
					System.out.println("+");
				}
			}
			System.out.println();
		}
*/
	}
}
