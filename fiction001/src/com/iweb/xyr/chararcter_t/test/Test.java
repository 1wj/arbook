package com.iweb.fiction.chararcter_t.test;

import com.iweb.fiction.chararcter_t.model.Character_t;
import com.iweb.fiction.chararcter_t.service.CharacterService;
import com.iweb.fiction.chararcter_t.service.CharacterServiceImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.print(1);

        /*CharacterService bs = new CharacterServiceImpl();
        List<Character_t> bt = bs.queryAll();
        System.out.print(bt);//查询全部*/

        /*CharacterService bs = new CharacterServiceImpl();
        int i =bs.saveOne(new Character_t("44","3","第一章","文档文档"));
        System.out.println(i);//新增*/

        /*CharacterService bs = new CharacterServiceImpl();
        int i =bs.updateOne(new Character_t("44","3","第四章","文档文档文档"));
        System.out.println(i);//修改*/

        /*CharacterService bs = new CharacterServiceImpl();
        Character_t ct= bs.queryById("44","3");
        System.out.println(ct);//查询*/

        /*CharacterService bs = new CharacterServiceImpl();
        int i = bs.deleteById("44","3");
        System.out.println(i);//删除*/
    }
}
