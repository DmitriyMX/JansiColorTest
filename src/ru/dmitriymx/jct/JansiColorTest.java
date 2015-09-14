package ru.dmitriymx.jct;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class JansiColorTest {
    static final String gyw = " gYw ";

    public static void main(String[] args) {
        if (Boolean.getBoolean("ansi.install")) {
            AnsiConsole.systemInstall();
        }
        
        final Ansi ansi = ansi().reset();
        
        ansi.newline().a("[DEFAULT]").newline();
        defaultColorTest(ansi);
        
        ansi.newline().a("[BRIGHT]").newline();
        brightColorTest(ansi);
        
        System.out.print(ansi.reset().toString());
    }
    
    private static void defaultColorTest(Ansi ansi) { 
        // Шапка названий светов
        ansi.a('\t');
        for(Ansi.Color color : Ansi.Color.values()) {
            ansi.a(color.name()).a('\t');
        }
        ansi.reset().newline();
        
        for(Ansi.Color f_color : Ansi.Color.values()) {
            // Название цвета текста
            ansi.a(f_color.name()).a('\t');
            // Цвет текста
            ansi.fg(f_color);
            
            // тест цвета фона                        
            for(Ansi.Color b_color : Ansi.Color.values()) {
                ansi.bg(b_color).a(gyw).a('\t');
            }
            
            ansi.reset().newline();
            
            // Включаем "жир"
            ansi.bold().a('\t');
            // Цвет текста
            ansi.fg(f_color);
            
            // тест цвета фона                        
            for(Ansi.Color b_color : Ansi.Color.values()) {
                ansi.bg(b_color).a(gyw).a('\t');
            }
            
            ansi.boldOff().reset().newline();
        }
    }
    
    private static void brightColorTest(Ansi ansi) {
        // Шапка названий светов
        ansi.a('\t');
        for(Ansi.Color color : Ansi.Color.values()) {
            ansi.a(color.name()).a('\t');
        }
        ansi.reset().newline();
        
        for(Ansi.Color f_color : Ansi.Color.values()) {
            // Название цвета текста
            ansi.a(f_color.name()).a('\t');
            // Цвет текста
            ansi.fgBright(f_color);
            
            // тест цвета фона                        
            for(Ansi.Color b_color : Ansi.Color.values()) {
                ansi.bgBright(b_color).a(gyw).a('\t');
            }
            
            ansi.reset().newline();
            
            // Включаем "жир"
            ansi.bold().a('\t');
            // Цвет текста
            ansi.fgBright(f_color);
            
            // тест цвета фона                        
            for(Ansi.Color b_color : Ansi.Color.values()) {
                ansi.bgBright(b_color).a(gyw).a('\t');
            }
            
            ansi.boldOff().reset().newline();
        }
    }
}
