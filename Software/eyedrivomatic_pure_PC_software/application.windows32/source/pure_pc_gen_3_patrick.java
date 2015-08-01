import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pure_pc_gen_3_patrick extends PApplet {

// Many thanks to Carlos William Galdino whose instructable set me on the right path. 
// http://www.instructables.com/id/Arduino-USB-comunication-Example-Program

//start serial communication
Serial Port;

int driveSwitchState = 0;
int onOffState = 0;
int lastBut = 0;
int  last;

//variables received from the Arduino 
int data0;    //data 1 received from Arduino driveSwitchState
int data1;    //data 2 received from Arduino speedState
int data2;    //data 3 received from Arduino joystickState
float data3;    //data 4 received from Arduino durationTime
int data4;    //data 5 received from Arduino continueState
int data5;    //data 6 received from Arduino driveSwitchStateNS
int data6;    //data7 received from Arduino speedStateNS
int data7;    //data8 received from Arduino joystickStateNS
float data8;    //data9 received from Arduino durationTimeNS
int data9;    //data10 received from Arduino continueStateNS
int data10;    //data11 received from Arduino driveSwitchStateEW
int data11;    //data12 received from Arduino speedStateEW
int data12;    //data13 received from Arduino joystickStateEW
float data13;    //data14 received from Arduino durationTimeEW
int data14;    //data15 received from Arduino continueStateEW
int data15;    //data16 received from Arduino spare 

public void setup (){ 
  
  
  int  last = millis();  
  size (1260,790);    //Initialise the window's size
  if (frame != null) {
    frame.setResizable(true);
  }
  frame.setTitle("Eyedrivomatic Pure 3");
  Port = new Serial(this, "COM8", 9600); //starts the Serial port - COM4
  Port.bufferUntil('\n'); //clean the buffer
  
  
}

public void draw (){ //starts loop

  background(0); //Background Color  
  
  PImage green50 = loadImage("green50.png"); 
  image(green50,0,0);
  
  switch (data4){
    case 0: 
    PImage contPicB = loadImage("9-9.png"); 
    image(contPicB,961,7);
    break; 
    case 1: 
    PImage contPic = loadImage("9-8.png"); 
    image(contPic,961,7);
    break;     
  }
    
  switch (data2){
    case 0: 
    PImage readyPicB = loadImage("9-1.png"); 
    image(readyPicB,847,7);
    break;
    case 1: 
    if (data4 == 0){
    PImage nwPic = loadImage("1-1.png"); 
    image(nwPic,847,7);
    }
    else {
    PImage nwPicb = loadImage("1-1b.png"); 
    image(nwPicb,847,7);
    }
    break;
    case 2: 
    if (data4 == 0){
    PImage nePic = loadImage("5-1.png"); 
    image(nePic,847,7);
    }
    else {
    PImage nePicb = loadImage("5-1b.png"); 
    image(nePicb,847,7);
    }
    break;
    case 3: 
    if (data4 == 0){
    PImage sePic = loadImage("5-5.png"); 
    image(sePic,847,7);
    }
    else {
    PImage sePicb = loadImage("5-5b.png"); 
    image(sePicb,847,7);
    }
    break;
    case 4: 
    if (data4 == 0){
    PImage swPic = loadImage("1-5.png"); 
    image(swPic,847,7);
    }
    else {
    PImage swPicb = loadImage("1-5b.png"); 
    image(swPicb,847,7);
    }
    break;
  }
  
  switch (data9){
    case 0: 
    PImage contPicB = loadImage("9-9.png"); 
    image(contPicB,541,7);
    break; 
    case 1: 
    PImage contPic = loadImage("9-8.png"); 
    image(contPic,541,7);
    break;     
  }
    
  switch (data7){
    case 0: 
    PImage readyPicB = loadImage("9-1.png"); 
    image(readyPicB,427,7);
    break;
    case 1: 
    if (data9 == 0){
    PImage nPic = loadImage("3-1.png"); 
    image(nPic,427,7);
    }
    else {
    PImage nPicb = loadImage("3-1b.png"); 
    image(nPicb,427,7);
    }
    break;
    case 2: 
    if (data9 == 0){
    PImage sPic = loadImage("3-5.png"); 
    image(sPic,427,7);
    }
    else {
    PImage sPicb = loadImage("3-5b.png"); 
    image(sPicb,427,7);
    }
    break;
  }
  
  switch (data14){
    case 0: 
    PImage contPicB = loadImage("9-9.png"); 
    image(contPicB,121,7);
    break; 
    case 1: 
    PImage contPic = loadImage("9-8.png"); 
    image(contPic,121,7);
    break;     
  }
    
  switch (data12){
    case 0: 
    PImage readyPicB = loadImage("9-1.png"); 
    image(readyPicB,7,7);
    break;
    case 1: 
    if (data14 == 0){
    PImage ePic = loadImage("5-3.png"); 
    image(ePic,7,7);
    }
    else {
    PImage ePicb = loadImage("5-3b.png"); 
    image(ePicb,7,7);
    }
    break;
    case 2: 
    if (data14 == 0){
    PImage wPic = loadImage("1-3.png"); 
    image(wPic,7,7);
    }
    else {
    PImage wPicb = loadImage("1-3b.png"); 
    image(wPicb,7,7);
    }
    break;
  }

  PFont f1 = loadFont("Arial-Black-48.vlw"); //fonts
  PFont f2 = loadFont("Arial-Black-36.vlw"); //fonts
  PFont f3 = loadFont("Arial-Black-28.vlw"); //fonts
  
//ew information 
  textFont(f3);
  fill(0);
  text("secs", 332, 46);

if (data11 == 1){
  textFont(f3);
  fill(255, 0, 4);
  text("SLOW", 273, 91);
}
if (data11 == 2){
  textFont(f3);
  fill(0, 115, 242);
  text("WALK", 273, 91);
}
if (data11 == 3){
  textFont(f3);
  fill(0, 115, 206);
  text("FAST", 279, 91);
}
  textFont(f3);
  fill(255, 0, 4);
  text((data13 / 1000), 230, 48);  
  
    //ns information 
  textFont(f3);
  fill(0);
  text("secs", 752, 46);

if (data6 == 1){
  textFont(f3);
  fill(255, 0, 4);
  text("SLOW", 693, 91);
}
if (data6 == 2){
  textFont(f3);
  fill(0, 115, 242);
  text("WALK", 693, 91);
}
if (data6 == 3){
  textFont(f3);
  fill(0, 115, 206);
  text("FAST", 699, 91);
}
if (data6 == 4){
  textFont(f2);
  fill(0, 115, 206);
  text("MANIC", 693, 85);
}
  textFont(f3);
  fill(255, 0, 4);
  text((data8 / 1000), 650, 48);  
  
 //diagonal information 
 
  textFont(f3);
  fill(0);
  text("secs", 1172, 46);

if (data1 == 1){
  textFont(f3);
  fill(255, 0, 4);
  text("SLOW", 1113, 91);
}
if (data1 == 2){
  textFont(f3);
  fill(0, 115, 242);
  text("WALK", 1113, 91);
}
if (data1 == 3){
  textFont(f3);
  fill(0, 115, 206);
  text("FAST",1119, 91);
}
  textFont(f3);
  fill(255, 0, 4);
  text((data3 / 1000), 1070, 48);  
    
}

public void keyPressed(){
 
  
  switch (key) {
      case 'a':
      Port.write(34);  //stop  
      break;
      case 'b':
      Port.write(35);//mode 
      break;
      case 'c':
      Port.write(36); //mode x 5
      break;
      case 'd':
      lastBut = 1;
      Port.write(37); //nw
      break;
      case 'e':
      lastBut = 2;
      Port.write(38);  //n
      break;
      case 'f':
      lastBut = 3;
      Port.write(39);  //ne
      break;
      case 'g':
      lastBut = 4;
      Port.write(40);  //e
      break;
      case 'h':
      lastBut = 5;
      Port.write(41);  //se
      break;
      case 'i':
      lastBut = 6;
      Port.write(42);  //s
      break;
      case 'j':
      lastBut = 7;
      Port.write(43);  //sw
      break;
      case 'k':
      lastBut = 8;
      Port.write(44);  //w
      break;
      case 'l':
      Port.write(45); //speed up 
      break;
      case 'm':
      Port.write(46); //speed down 
      break;
      case 'n':
      Port.write(47); //continue 
      break;
      case 'o':
      Port.write(48); //aux
      break;
      case 'p':
      Port.write(49); //stop 
      break;
      case 'q':
      Port.write(50); //ns speed 1 
      break;
      case 'r':
      Port.write(51); //ns speed 2  
      break;
      case 's':
      Port.write(52); //ns speed 3
      break;
      case 't':
      Port.write(53); //ns speed 4
      break;
      case 'u':
      Port.write(54); // ew speed 1
      break;
      case 'v':
      Port.write(55); // ew speed 2
      break;
      case 'w':
      Port.write(56); // ew speed 3
      break;
      case 'x':
      Port.write(57); // diagonal speed 1
      break;
      case 'y':
      Port.write(58); // diagonal speed 2
      break;
      case 'z':
      Port.write(59); // diagonal speed 3
      break;
      case '1':
      Port.write(60); // ns duration =  half 
      break;
      case '2':
      Port.write(61); // ns duration =  1
      break;
      case '3':
      Port.write(62); // ns duration =  2
      break;
      case '4':
      Port.write(63); // ns duration =  3
      break;
      case '5':
      Port.write(64); // ns duration =  4
      break;
      case '6':
      Port.write(65); // ns duration =  6
      break;
      case '7':
      Port.write(66); // ew duration =  half 
      break;
      case '8':
      Port.write(67); // ew duration =  1
      break;
      case '9':
      Port.write(68); // ew duration =  2
      break;
      case '0':
      Port.write(69); // ew duration =  3
      break;
      case '.':
      Port.write(70); // ew duration =  4
      break;
      case ',':
      Port.write(71); // diagonal duration =  half 
      break;
      case '/':
      Port.write(72); // diagonal duration =  1
      break;
      case ';':
      Port.write(73); // diagonal duration = 2 
      break;
      case '#':
      Port.write(74); // diagonal duration =  3
      break;
      case '[':
      Port.write(75); // diagonal duration =  4
      break;
  }
}

public void serialEvent (Serial Port) {    //receive the USB data from Arduino 

  try {
  
    String receivedArduino = Port.readStringUntil('\n'); // read the buffer
    
    receivedArduino = trim(receivedArduino); //erase ALL the possible spaces between the letters 
 
    int data[] = PApplet.parseInt(split(receivedArduino, ',')); //this function splits the string and put a comma between the data
    //it also convert the string in "int"
    
    data0 = data[0];    //data 0 received from Arduino
    data1 = data[1];    //data 1 received from Arduino
    data2 = data[2];    //data 3 received from Arduino
    data3 = data[3];    //data 4 received from Arduino
    data4 = data[4];    //data 5 received from Arduino
    data5 = data[5];    //data 6 received from Arduino
    data6 = data[6];    //data7 received from Arduino speedStateNS
    data7 = data[7];    //data8 received from Arduino joystickStateNS
    data8 = data[8];    //data9 received from Arduino durationTimeNS
    data9 = data[9];    //data10 received from Arduino continueStateNS
    data10 = data[10];    //data11 received from Arduino driveSwitchStateEW
    data11 = data[11];    //data12 received from Arduino speedStateEW
    data12 = data[12];    //data13 received from Arduino joystickStateEW
    data13 = data[13];    //data14 received from Arduino durationTimeEW
    data14 = data[14];    //data15 received from Arduino continueStateEW
    data15 = data[15];    //data16 received from Arduino spare 
    // add two linefeed after all the sensor values are printed:
    println();
    println();
    
    
    Port.write("!"); // send a byte (! - 33) to ask for more data 
    
    
  }
  catch(RuntimeException e) {
    //do something? 
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pure_pc_gen_3_patrick" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
