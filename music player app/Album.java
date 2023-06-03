import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name,String artist){           // constructor
        this.name=name;
        this.artist=artist;
        this.songs=new ArrayList<>();
    }

    public Song findSong(String title){
        for(Song checkedSong: songs){
            if(checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }

    public boolean addsong(String title,double duration){    // if the song does not exist in list then only it will get added
        if(findSong(title)==null){                           // i.e if findSong will return null the song will get added in list
            songs.add(new Song(title, duration));
//            System.out.println(title + "has been successfully added");
            return true;
        }
        else{
//            System.out.println("song with title "+title+" already exist in the list");
            return false;
        }
    }

    public boolean addToPlaylist(String title,LinkedList<Song> Playlist){ // this will add the songs from album to playlist
        for(Song checkedSong:songs){
            if(checkedSong.getTitle().equals(title)){
                Playlist.add(checkedSong);
                return true;
            }                          
        }
        return false;
    }
}
