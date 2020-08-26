package com.kirilo.jsp.beans;

import com.kirilo.jsp.enums.LangList;

public class LetterList {
    private LangList lang;

    //    private char[] chars;

    public LetterList() {
        lang = LangList.EN;
    }

    public LangList getLang() {
        return lang;
    }

    public void setLang(LangList lang) {
        this.lang = lang;
    }

/*    public char[] getChars() {
        return chars;
    }*/

    public char[] getChars() {

        switch (lang) {
            case UA:
                return new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І',
                        'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',
                        'Ш', 'Щ', 'Ь', 'Ю', 'Я'
                };
            case RU:
                return new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Э', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
                        'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
                        'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
                };
            case EN:
            default:
                return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
                };
        }
    }
}
