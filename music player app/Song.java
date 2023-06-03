import java.lang.reflect.Constructor;

public class Song {
   String title;
   double duration;

   public Song(String title,double duration){                  // constructor
    this.title=title;
    this.duration=duration;                
   }

   public String getTitle(){
    return title;
   }

   public double getDuration(){
    return duration;
   }

   public String toString(){                                   // return property of Song class
    return "Song{"+"title='"+title+'\''+",duration="+duration+'}';
   }
}
