package com.example.dell.learnaboutromania;

/**
 * Created by kinga on 11/27/2017.
 */

public class Questions {
    public String mQuestions[]={
            "How do you answer to the quiestion: Cum te cheama?",
            "How do you answer to the quiestion: De unde esti",
            "If it is 8:00 am, how do you great someone?",
            "How do you apologies?",
            "My train goes from ... at 10:00 pm",
            "Where do you go to buy a book?",
            "Translate this sentance: Voriti romaneste?",
            "Translate these words: newspaper, ticket, tissue",
            "I am hungry. I would like to eat ...",
            "How do you ask the price of something",
            "What did Popey eat to be stong?",
            "My mum is a nurse and my dad works in school, so he is a/an ...",
            "If you had a headacke what do you ask for?",
            "Wow, how many likes she has on her ... in Instagram",
            "what does the bear like to eat?",
            "Continue the dilogue: Salut, ce faci?"
    };

    private String mChoices[][]={
            {"Numele meu este Andrei.","Bine, multumesc.", "Nu stiu."},
            {"Imi lipsesti.","Buna seara.", "Sunt din Cluj-Napoca."},
            {"Buna ziua.","Buna seara.", "Buna dimineata."},
            {"Te rog.","Imi pare rau.", "Multumesc."},
            {"restaurant","scoala", "gara"},
            {"librarie","biserica", "banca"},
            {"Do you speak Romanian?","What is your name?", "How are you?"},
            {"creion, telefon, poza","ziar, bilet, servetel", "ziar, caiet, ceas"},
            {"paine","cutit", "sticla"},
            {"Cum te cheama?","Unde este toaleta?", "Cat costa?"},
            {"orez","spanac", "supa"},
            {"profesor","lamaie", "inghetata"},
            {"oglinga","chibrit", "calmant"},
            {"ruj","poza", "ceapa"},
            {"lapte","ciuperca", "miere"},
            {"Bine multumesc.","Numele meu este...", "Bine ai venit "},

    };

    private String mCorrectAnswer[] = {"Numele meu este Andrei.", "Sunt din Cluj-Napoca.",
            "Buna dimineata.", "Imi pare rau.", "gara","librarie", "Do you speak Romanian?",
            "ziar, bilet, servetel","paine","Cat costa?","spanac","profesor","calmant",
            "poza", "miere","Bine multumesc."};


    public String getQuestion(int a){
        String question= mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer= mCorrectAnswer[a];
        return answer;
    }

}

