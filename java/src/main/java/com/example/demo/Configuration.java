package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylist;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            // private final IGreetingRepository greetingRepository = new GreetingRepository();
            private SongRepository songRepository = new SongRepository();
            private PlaylistRepository playlistRepository =new PlaylistRepository();
    
            // Initialize services
            // private final GreetingService greetingService = new GreetingService(greetingRepository);
            private SongService songService = new SongService(songRepository);
            private PlaylistService playlistService =new PlaylistService(playlistRepository,songRepository);
            private PlayerService playerService = new PlayerService(playlistService);

            // Initialize commands
            // private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            // private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            // private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private AddSongCommand addSongCommand = new AddSongCommand(songService);
            private ListSongCommand listSongCommand = new ListSongCommand(songService);
            private CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
            private LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(playerService);
            private PlaySongCommand playSongCommand = new PlaySongCommand(playerService);
            private NextSongCommand nextSongCommand = new NextSongCommand(playerService);
            private PreviousSongCommand previousSongCommand = new PreviousSongCommand(playerService);
            private StopSongCommand stopSongCommand = new StopSongCommand(playerService);
            private DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
            private DeleteSongFromPlaylist deleteSongFromPlaylist = new DeleteSongFromPlaylist(playlistService);
            private AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                // commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG.getName(),addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS.getName(),listSongCommand);
                commandRegistry.registerCommand( CommandKeyword.CREATE_PLAYLIST.getName(), createPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST.getName(),loadPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),stopSongCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST.getName(),deletePlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST.getName(),deleteSongFromPlaylist);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST.getName(),addSongToPlaylistCommand);

            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
