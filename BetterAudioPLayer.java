import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Stack;

public class BetterAudioPLayer
{

         static String[] array = {"preamble.wav","taunt.wav","gettysburg10.wav"};
         static ArrayList<String> playList = new ArrayList<>();
         static ArrayList<Llist> playlists = new ArrayList<>();

    public static void start() throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {


        try {
            int c = 0;


            System.out.println("Welcome to the audio player");
            System.out.println("press 1 to play default play list");
            System.out.println("press 2 Playlist mode ");
            System.out.println("press 3 Queue mode");

            Scanner sc = new Scanner(System.in);
             c = sc.nextInt();

            if(c==1)
            {
                defaultPlay();
            }
             else if(c==2)
            {
                playListMode();
            } else if (c==3)
            {
            queueMode();
            }
             else
             {
                 System.out.println("please enter from to given line");
                 start();
             }


        }catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    //Types to play

    public static void defaultPlay() throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        try {

            Llist Default = new Llist();
            for (int i = 0; i < array.length; i++)
            {
                Default.add(array[i]);
            }
            Scanner sc = new Scanner(System.in);

            playForeveryMode(Default);




        }catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
    public static void playListMode() throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        try
        {
            Scanner sc = new Scanner(System.in);



            System.out.println(" playList mode");
            System.out.println("press 0 to exit playlist");
            System.out.println("press 1 to print all playlists");
            System.out.println("press 2 to build playList");
            System.out.println("press 3 to select playlist");
            int c = sc.nextInt();

            if(c==0)
            {
                start();
            }
            if(c==1)
            {
            printAllPlaylists();
            playListMode();
            }
            if(c==2)
            {
                makePlaylist();
            }
            if(c==3)
            {

                playPlaylist();
            }

        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }




    //Methods
    public static void simplePlay(Llist l) throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Scanner sc = new Scanner(System.in);

        try
        {

            for (int i = 1; i < l.getLength()+1; i++)
            {
                System.out.println("playing "+ l.getEntry(i));

                Clip currentClip = playMusic(l.getEntry(i));
                while (currentClip.getMicrosecondLength()!=currentClip.getMicrosecondPosition())
                {

                }

            }
            defaultPlay();


        }catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void AscendingOrder(Llist l )throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        BST_class bst = new BST_class();
        for (int i = 1; i < l.getLength()+1; i++)
        {
         bst.insert(l.getEntry(i));
        }
        bst.inOrder_traversal();
        start();

    }
    public static void decendingOrder(Llist l )throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        BST_class bst = new BST_class();
        for (int i = 1; i < l.getLength()+1; i++)
        {
            bst.insert(l.getEntry(i));
        }
        bst.invert();
        bst.inOrder_traversal();
        start();

    }

    public static void makePlaylist()throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Press 0 to exit");
        System.out.println("press 1 to to print all songs");
        System.out.println("press 2 start adding songs");
        int c = sc.nextInt();

        if(c==0)
        {
            playListMode();
        }
        else if (c==1)
        {
            printAllsongs();
            makePlaylist();
        }
        else if (c==2)
        {

            int s = 1;
            System.out.println("Enter the name of the play list: ");
            String meow = sc.next();
            playList.add(meow);
            System.out.println("now Enter songs you want to play");
            Llist l = new Llist();
            System.out.println("press -1 to exit");
            while (s!=-1)
            {
                s = sc.nextInt();

                if(s!=-1)
                {
                    if(s<array.length)
                    {
                        l.add(array[s]);
                        System.out.println(array[s]+" Has been added in"+meow+"  playlist");
                    }
                    else
                    {
                        System.out.println("please enter from the given songs");
                        printAllsongs();
                    }

                }


            }
            playlists.add(l);
            makePlaylist();
        }


    }
    static Clip playMusic(String musicLocation)
    {
        try
        {
            File musicPath = new File(musicLocation);

            if(musicPath.exists())
            {
                AudioInputStream audioInput  = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                return clip;
            }
            else
            {
                System.out.println("cant find file");
            }
        }
        catch (Exception e)
        {
            System.out.println("blah blah");
        }
        return null;

    }
    public static void shufflePlay(Llist l )throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Random r = new Random();
        int c = r.nextInt(1,l.getLength()-1);
        Scanner sc = new Scanner(System.in);
        int input;
        int in;


        do
        {
            Clip currentClip =   playMusic(l.getEntry(r.nextInt(1,l.getLength()+2)));
            while (currentClip.getMicrosecondLength()!=currentClip.getMicrosecondPosition())
            {

            }
            System.out.println("press 0 to stop");
            input = sc.nextInt();

        }while (input!=0);

        defaultPlay();

    }
    

    static void printAllsongs()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(i+" "+array[i]);
        }
    }
    static void printAllPlaylists()
    {
        for (int i = 0; i < playList.size(); i++)
        {
            System.out.println(i+". "+playList.get(i));
        }
    }
    static void playPlaylist()throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter playlist number:");
        int s = sc.nextInt();
        if(playlists.isEmpty())
        {
            System.out.println("No playlist has been created");
            playListMode();
        }

         else if(s>playlists.size())
        {
            System.out.println("Error please choose from the given playlist");
            playPlaylist();
        }
        else
        {

            playForeveryMode(playlists.get(s));
        }

    }
    static void playForeveryMode(Llist l)throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("press 0 to exit playlist");
        System.out.println("press 1 to print  playlist");
        System.out.println("press 2 to play ");
        System.out.println("press 3 to shuffle play");
        System.out.println("press 4 to remove a song from playlist");
        System.out.println("press 5 to  play in ascending order");
        System.out.println("press 6 to play in descending order");



        int c = sc.nextInt();

        if(c==0)
        {
            start();
        }
        else if (c==1)
        {
            l.print();
            playForeveryMode(l);
        }
        else if (c==2)
        {
            simplePlay(l);
        }
        else if(c==3)
        {
            shufflePlay(l);
        }
        else if (c==4)
        {
            l.print();
            System.out.println("please enter the index of the number you want to remove from the playlist");
            int m = sc.nextInt();
            l.remove(m);
            playForeveryMode(l);
        }
        else if (c==5)
        {
            AscendingOrder(l);
        }
        else if(c==6)
        {
            decendingOrder(l);
        }
    }
    static void queueMode()throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
        int s=1;
        Scanner sc = new Scanner(System.in);
        Stack<String> queue = new Stack<>();

        System.out.println("now Enter songs you want to play");
        Llist l = new Llist();
        System.out.println("press -1 to exit");
        while (s!=-1)
        {
            s = sc.nextInt();

            if(s!=-1)
            {
                if(s<array.length)
                {
                    queue.push(array[s]);
                    System.out.println(array[s]+" Has been added in "+queue+"  queue");
                }
                else
                {
                    System.out.println("please enter from the given songs");
                    printAllsongs();
                }

            }

        }
        for (int i = -2; i < queue.size(); i++)
        {
            l.add(queue.pop());
        }
        l.print();
        System.out.println("press 1 to play queue");
        System.out.println("press 2 to exit queue mode");
        int  m = sc.nextInt();

        if (m==1)
        {
            try
            {

                for (int i = 1; i < l.getLength()+1; i++)
                {

                    System.out.println("playing "+ l.getEntry(i));

                    Clip currentClip = playMusic(l.getEntry(i));
                    while (currentClip.getMicrosecondLength()!=currentClip.getMicrosecondPosition())
                    {

                    }

                }
                start();


            }catch (Exception ex)
            {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        } else
        {
            start();
        }
    }




}