/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.posternlp;

/**
 *
 * @author 尚宏
 */
public interface PosterNLPSegImpl {    
    public abstract String[] getStringToken(String str) throws PosterNLPException;
}
