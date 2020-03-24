package com.company.Classes;

import com.company.Structs.Player;

import java.util.List;

public class myFunc {

    public static Object SearchInList(List<Object> tList, Object search) {
        for (Object v:tList) {
            if(v==search)return v;
        }
        return null;
    }
}
