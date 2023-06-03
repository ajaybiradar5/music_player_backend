import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.Action;

public class Main{

    private static ArrayList<Album> albums =new ArrayList<>();
    public static void main(String args[]){

        Album album = new Album("Album_1", "AC/DC");

        album.addsong("TNT", 4.5);
        album.addsong("highway to hell", 3.5);
        album.addsong("thunderstruck", 5.0);
        albums.add(album);

        album = new Album("Album_2", "Eminem");
        
        album.addsong("rap god", 4.5);
        album.addsong("not afraid", 4.0);
        album.addsong("lose yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playList_1=new LinkedList<>();

        albums.get(0).addToPlaylist("TNT",playList_1);
        albums.get(0).addToPlaylist("thunderstruck",playList_1);
        albums.get(1).addToPlaylist("rap god",playList_1);
        albums.get(1).addToPlaylist("not afraid",playList_1);

        play(playList_1);

    }
    private static void play(LinkedList<Song>playList){
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playList.listIterator();

        if(playList.size() == 0){
            System.out.println("songs are not available in playlist");
        }
        else{
            System.out.println("now playing "+ listIterator.next().toString());
            printmenu();
        }

        while(!quit){
            int action= sc.nextInt();
            sc.nextLine();

            switch(action){

                case 0:
                    System.out.println("playlist completed");
                    quit=true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }

                    if(listIterator.hasNext()){
                        System.out.println("now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("no song available ,reache at the end of playlist");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }

                    if(listIterator.hasPrevious()){
                        System.out.println("now playing "+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("we are at the first song");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                        else{
                            System.out.println("we are at start at the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we are at end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printmenu();
                    break;

                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                    }
                    else{
                        if(listIterator.hasPrevious()){
                            System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }
                    break;
                    
            }
        }
    }

    private static void printmenu(){
        System.out.println("Available options\n press");
        System.out.println(
            "0 - to quit\n"+
            "1 - to play the next song\n"+
            "2 - to play the previous song\n"+
            "3 - to replay the current song\n"+
            "4 - list all the song\n"+
            "5 - print all the available option\n"+
            "6 - delete the current song"
        );
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator= playList.iterator();
        System.out.println("----------------------");      

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");
    }
}