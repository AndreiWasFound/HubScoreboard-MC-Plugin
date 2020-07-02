package me.AndreiWasFound.HubScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin implements Listener {
	
	private int taskID;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		
		if (!Bukkit.getOnlinePlayers().isEmpty())
			for (Player online : Bukkit.getOnlinePlayers()) {
				createBoard(online);
				start(online);
			}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		createBoard(event.getPlayer());
		start(event.getPlayer());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		LobbyBoard board = new LobbyBoard(event.getPlayer().getUniqueId());
		if (board.hasID())
			board.stop();
	}
	
	
	public void start(Player player) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			int count = 0;
			LobbyBoard board = new LobbyBoard(player.getUniqueId());
			
			@Override
			public void run() {
				if (!board.hasID())
					board.setID(taskID);
				if (count == 13)
					count = 0;
				
				switch(count) {
				case 0:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< &2&lAndreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 1:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< &d&lA&2&lndreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 2:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< A&d&ln&2&ldreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 3:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< An&d&ld&2&lreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 4:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< And&d&lr&2&leiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 5:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< Andr&d&le&2&liWasFound &a&l>>"));
					createBoard(player);
					break;
				case 6:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< Andre&d&li&2&lWasFound &a&l>>"));
					createBoard(player);
					break;
				case 7:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< Andrei&d&lW&2&lasFound &a&l>>"));
					createBoard(player);
					break;
				case 8:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiW&d&la&2&lsFound &a&l>>"));
					createBoard(player);
					break;
				case 9:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWa&d&ls&2&lFound &a&l>>"));
					createBoard(player);
					break;
				case 10:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWas&d&lF&2&lound &a&l>>"));
					createBoard(player);
					break;
				case 11:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWasF&d&lo&2&lund &a&l>>"));
					createBoard(player);
					break;
				case 12:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWasFo&d&lu&2&lnd &a&l>>"));
					createBoard(player);
					break;
				case 13:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWasFou&d&ln&2&ld &a&l>>"));
					createBoard(player);
					break;
				case 14:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWasFoun&d&ld &a&l>>"));
					createBoard(player);
					break;
				case 15:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< &d&lAndreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 16:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< &2&lAndreiWasFound &a&l>>"));
					createBoard(player);
					break;
				case 17:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName
					(ChatColor.translateAlternateColorCodes('&', "&a&l<< &d&lAndreiWasFound &a&l>>"));
					createBoard(player);
					break;
				}
				count++;
			}
			
		}, 0, 10);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("HubScoreboard-1", "dummy", 
				ChatColor.translateAlternateColorCodes('&', "&a&l<< AndreiWasFound &a&l>>"));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score = obj.getScore(ChatColor.BLUE + "=-=-=-=-=-=-=-=-=");
		score.setScore(3);
		Score score2 = obj.getScore(ChatColor.AQUA + "Online players: " + ChatColor.DARK_AQUA + Bukkit.getOnlinePlayers().size());
		score2.setScore(2);
		Score score3 = obj.getScore(ChatColor.AQUA + "Total Mob Kills: " + ChatColor.DARK_AQUA + player.getStatistic(Statistic.MOB_KILLS));
		score3.setScore(1);
		player.setScoreboard(board);
	}

}
