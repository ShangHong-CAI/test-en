/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 尚宏
 */
public class NLPTest {
    
    public static void main(String[] args){
        POS_arabic arabic =new POS_arabic();
        POS_english english =new POS_english();
        POS_french french = new POS_french();
        POS_german german =new POS_german();
        POS_japan japan =new POS_japan();
        POS_korea korea =new POS_korea();
        POS_russian russian =new POS_russian();
        POS_spanish spanish =new POS_spanish();
         try {
            String str ="雖然常跑馬拉松的人普遍被視為很健康，但新研究顯示，每跑完26.2哩的馬拉松，對人體的負擔相當重，除了會耗損肌肉、骨頭和心臟，對腎臟也有影響；「就像剛接受開心手術」，研究報告說。 由耶魯醫學院所做的新研究發現，80%剛跑完馬拉松的人的腎臟狀態和剛做完心臟手術的病人相似。研究的主要作者、耶魯大學腎病專家帕瑞克(Chirag Parikh)表示：「我們無法辨別剛跑完馬拉松的跑者和剛接受過心臟手術的患者的區別。」 這份於28日刊登在「美國腎臟疾病期刊」(American Journal of Kidney Diseases)上的研究，以22名(9男13女)跑了五年以上馬拉松的跑者的血液和尿液為研究樣本。研究發現，絕大多數的跑者在跑完馬拉松後的肌酸(creatine)和炎性蛋白質(inflammatory protein)水平，和患有急性腎損傷的病人類似。 帕瑞克表示，劇烈慢跑在好幾個方面都可能會損害到人的腎臟，脫水會讓腎臟承受沉重的壓力。跑步本身也會提升人體的溫度，造成人全身性的發炎和肌肉的過勞。這些都導致人們的血液產生更多需要被過濾掉的蛋白質，致使腎臟過勞。 之後，人體為了防止過熱和雙腿無法正常活動，會將發揮降溫功能的血液輸送至皮膚和肌肉的表層，減少對腎臟的輸血。連續數小時的劇烈活動、缺水和血液供給的減少，幾乎必然會傷害人的腎臟。 這項新研究對馬拉松跑者而言並非是個噩夢，一般馬拉松跑者的身體狀態在跑完馬拉松的兩天內，能夠恢復正常。就算是那些超級馬拉松賽職業選手的身體，只要沒有什麼潛在的身體問題，最終也能夠完全恢復正常。 帕瑞克指出，倒是那些在熱帶地區、每天要在炎熱天氣下工作10至12小時的人處境令人擔心。這些工人通常都會承受和馬拉松跑者類似的生理負擔，比一般人更容易患得慢性腎臟病。\n" +
"";
            String[] list =str.split(" ");
//            list=loopNLP(list,english);
//            list=loopNLP(list,japan);
            list=loopNLP(list,korea);
            for(String s:list){
                System.out.println(s);
            }
            
        } catch (PosterNLPException ex) {
            Logger.getLogger(NLPTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static String[] loopNLP(String[] input_text,PosterNLPSegImpl nlp) throws PosterNLPException{
        ArrayList<String> list = new ArrayList<String>();        
       String[] result1 = null;
        for(String str:input_text){
            String[] result2= nlp.getStringToken(str);
            result1 =addAll(result1, result2);
        }
        return result1;
    }
    public static String[] addAll(String[] array1, String[] array2) {
        if (array1 == null) {
            return clone(array2);
        } else if (array2 == null) {
            return clone(array1);
        }
        String[] joinedArray = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }
    public static String[] clone(String[] array) {
        if (array == null) {
            return null;
        }
        return (String[]) array.clone();
    }
    
}
