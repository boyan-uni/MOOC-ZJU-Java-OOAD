package javaoop.w5_designprinciple.castle_amend;

import javaoop.w5_designprinciple.castle_amend.handlers.Handler;
import javaoop.w5_designprinciple.castle_amend.handlers.HandlerBye;
import javaoop.w5_designprinciple.castle_amend.handlers.HandlerGo;
import javaoop.w5_designprinciple.castle_amend.handlers.HandlerHelp;

import java.util.HashMap;
import java.util.Scanner;


public class Game {

    private Room currentRoom;

    private HashMap<String, Handler> handlers= new HashMap<>();
        
    public Game() 
    {
        // 初始化 Handlers
        handlers.put("bye", new HandlerBye(this)); // bye 命令
        handlers.put("help", new HandlerHelp(this)); // help 命令
        handlers.put("go", new HandlerGo(this)); // go 命令 与 game对象内数据有关
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口
        outside.setExits("east",lobby);
        outside.setExits("south",study);
        outside.setExits("west",pub);
        lobby.setExits("west",outside);
        pub.setExits("east",outside);
        study.setExits("north",outside);
        study.setExits("east",bedroom);
        bedroom.setExits("west",study);

        currentRoom = outside;  //	从城堡门外开始
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        while ( true ) {
            String line = in.nextLine();
            String[] words = line.split(" "); // TODO：如何解析用户输入的命令，根据解析出的不同的字符串，转到对应的函数？

            Handler handler = handlers.get(words[0]); // 根据命令动态分配handler

            String value = "";
            if (words.length>1){
                value = words[1];
            }
            if (handler!=null){ // 已经根据输入""找到对应handler
                handler.doCmd(value);
                if (handler.isBye()) break;
            }


            /*if(words.length==1) {
                // 用户命令长度为1
                if (handlers.get("bye").isBye(words[0])) { // bye
                    handlers.get("bye").doCmd(words[0]);
                    break;
                }else if(handlers.get("help").isHelp(words[0])) { // help
                    handlers.get("help").doCmd(words[0]);
                }
            } else if (words.length==2 && handlers.get("go").isGo(words[0])) { // go direction
                handlers.get("go").doCmd(words[1]);
            }*/
        }
    }

    private void printWelcome() {
        System.out.println("城堡游戏 Castle Game！");
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        this.showPrompt();
    }

    private void showPrompt(){  // 提示信息
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.println(currentRoom.showExists());
    }

    // 以下为用户命令 Go 通过 Handler 转来的 所以改为 public

    public void goRoom(String direction)
    {
        Room nextRoom=null;

        if (currentRoom.hasExist(direction)!=null){
            nextRoom = currentRoom.hasExist(direction);
            currentRoom = nextRoom; // 进入下一房间
            this.showPrompt();
        }
        else{
            System.out.println("那里没有门！");
        }

    }

    // 游戏运行入口

	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
        game.play();
	}

}
