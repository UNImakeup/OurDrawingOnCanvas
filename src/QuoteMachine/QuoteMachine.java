package QuoteMachine;

import com.sun.webkit.graphics.WCTransform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;

public class QuoteMachine {

    int iterator = 0;

    private ArrayList<Quote> quotes = new ArrayList<>();

    public QuoteMachine()
    {
        genrateQuotes();
    }

    public void genrateQuotes()
    {
        quotes.add(new Quote("I draw like other people bite their nails.", "Pablo Picasso"));
        quotes.add(new Quote("All the visible world is only light on form.", "Andrew Loomis" ));
        quotes.add(new Quote("One must always draw, draw with the eyes, when one cannot draw with a pencil.", "Balthus" ));
        quotes.add(new Quote("It is only by drawing often, drawing everything, drawing incessantly, that one fine day you discover, to your surprise, that you have rendered something in its true character.", "Camille Pissarro"));
        quotes.add(new Quote("Drawing is vision on paper.", "Andrew Loomis"));
        quotes.add(new Quote("I love the quality of pencil. It helps me to get to the core of a thing.", "Andrew Wyeth"));
        quotes.add(new Quote("Photography is an immediate reaction, drawing is a meditation.", "Henri Cartier-Bresson"));
        quotes.add(new Quote("Learning to draw is really a matter of learning to see - to see correctly - and that means a good deal more than merely looking with the eye.", "Kimon Nicolaides"));
        quotes.add(new Quote("Drawing is rather like playing chess: your mind races ahead of the moves that you eventually make.", "David Hockney"));
        quotes.add(new Quote("You can't do sketches enough. Sketch everything and keep your curiosity fresh.", "John Singer Sargent"));
        quotes.add(new Quote("Drawing is the basis of art. A bad painter cannot draw. But one who draws well can always paint.", "Arshile Gorky"));
        quotes.add(new Quote("Drawing is the artist's most direct and spontaneous expression, a species of writing: it reveals, better than does painting, his true personality.", "Edgar Degas"));
        quotes.add(new Quote("Drawing is not what one sees but what one can make others see.", "Edgar Degas"));
        quotes.add(new Quote("Drawing is putting a line (a)round an idea.", "Henri Matisse"));
        quotes.add(new Quote("In drawing, nothing is better than the first attempt.", "Pablo Picasso"));
        quotes.add(new Quote("Drawing is the honesty of the art. There is no possibility of cheating. It is either good or bad.", "Salvador Dali"));
        quotes.add(new Quote("In drawing, one must look for or suspect that there is more than is casually seen.", "George Bridgman"));
        quotes.add(new Quote("If you can draw well, tracing won’t hurt; and if you can’t draw well, tracing won’t help.", "Bradley Schmehl"));
        quotes.add(new Quote("The important thing is to keep on drawing when you start to paint. Never  graduate from drawing.", "John Sloan"));

        Collections.shuffle(quotes);
    }

    public Quote getQuote()
    {
        if (iterator < quotes.size())
        {
            iterator++;
            return quotes.get(iterator-1);
        }
        else
        {
            iterator = 0;
            return getQuote();
        }
    }
}
