#include <Adafruit_NeoPixel.h>

#define PIN 6
#define NUMLEDS 30
#define DELAY 25
#define RAINBOWVALUE 17
#define FADEVALUE 64

Adafruit_NeoPixel strip = Adafruit_NeoPixel(16, 12 , NEO_GRB + NEO_KHZ800);
Adafruit_NeoPixel strip2 = Adafruit_NeoPixel(NUMLEDS, PIN, NEO_GRB + NEO_KHZ800);

int pattern = 1, counter = 0, onStep = 0, pause = 1;
int holder[3] = {255,0,0}, color[2] = {0,0}, stripData[NUMLEDS];

void setup() {
  Serial.begin(9600);
  strip.begin();
  strip.show();
  strip.setBrightness(128);
  delay(100);
  for(int x = 0; x <16; x++) {
  strip.setPixelColor(x, 0, 255, 0);
  }
  strip.show();
  randomSeed(analogRead(0));
  for (int x=0;x<NUMLEDS;x++) {
    stripData[x] = 0;
    stripData[x] += random(1,4);
    stripData[x] += random(1,4)*10;
  }
  strip2.begin();
  strip2.show();
}

void loop() {
  if (pattern==1) {
    for (int x=0;x<NUMLEDS;x++) {
      if (x<NUMLEDS/3) {
        strip2.setPixelColor((x+counter)%NUMLEDS, 255-x*255/(NUMLEDS/3), x*255/(NUMLEDS/3), 0);
      } else if (x<2*NUMLEDS/3) {
        strip2.setPixelColor((x+counter)%NUMLEDS, 0, 255-(x-NUMLEDS/3)*255/(NUMLEDS/3), (x-NUMLEDS/3)*255/(NUMLEDS/3));
      } else {
        strip2.setPixelColor((x+counter)%NUMLEDS, (x-2*NUMLEDS/3)*255/(NUMLEDS/3), 0, 255-(x-2*NUMLEDS/3)*255/(NUMLEDS/3));
      }
    }
    counter = (counter+1)%NUMLEDS;
  } else if (pattern==2) {
    int temp[3] = {holder[0],holder[1],holder[2]};
    for (int x=0;x<NUMLEDS/2;x++) {
      strip2.setPixelColor(NUMLEDS/2-(x+1), temp[0], temp[1], temp[2]);
      strip2.setPixelColor(NUMLEDS/2+x, temp[0], temp[1], temp[2]);
      if (temp[0]<255 && temp[1]>0 && temp[2]==0) {
        temp[0] += VALUE;
        temp[1] -= VALUE;
      } else if (temp[1]<255 && temp[2]>0 && temp[0]==0) {
        temp[1] += VALUE;
        temp[2] -= VALUE;
      } else {
        temp[2] += VALUE;
        temp[0] -= VALUE;
      }
    }
    if (holder[0]>0 && holder[1]<255 && holder[2]==0) {
      holder[0] -= VALUE;
      holder[1] += VALUE;
    } else if (holder[1]>0 && holder[2]<255 && holder[0]==0) {
      holder[1] -= VALUE;
      holder[2] += VALUE;
    } else {
      holder[2] -= VALUE;
      holder[0] += VALUE;
    }
  } else if (pattern==3) {
    int temp[2] = {color[0],color[1]};
    if (temp[1]>255) {
      temp[0] -= 1;
    } else if (temp[1]==0) {
      temp[0] = (temp[0]+5)%6;
     }
    for (int x=0;x<NUMLEDS;x++) {
      if (temp[0]<2) {
        strip2.setPixelColor(x, temp[1]-1, 0, 0);
      } else if (temp[0]>1 && temp[0]<4) {
        strip2.setPixelColor(x, 0, temp[1]-1, 0);
      } else {
        strip2.setPixelColor(x, 0, 0, temp[1]-1);
      }
      if (temp[0]==0) {
        temp[1] -= FADEVALUE;
      } else if (temp[0]==1) {
        temp[1] += FADEVALUE;
      } else if (temp[0]==2) {
        temp[1] -= FADEVALUE;
      } else if (temp[0]==3) {
        temp[1] += FADEVALUE;
      } else if (temp[0]==4) {
        temp[1] -= FADEVALUE;
      } else {
        temp[1] += FADEVALUE;
      }
      if (temp[1]>255) {
        temp[0] -= 1;
      } else if (temp[1]==0) {
        temp[0] = (temp[0]+5)%6;
      }
    }
    if (color[0]==0) {
      color[1] += FADEVALUE;
    } else if (color[0]==1) {
      color[1] -= FADEVALUE;
    } else if (color[0]==2) {
      color[1] += FADEVALUE;
    } else if (color[0]==3) {
      color[1] -= FADEVALUE;
    } else if (color[0]==4) {
      color[1] += FADEVALUE;
    } else {
      color[1] -= FADEVALUE;
    }
    if (color[1]>255) {
      color[0] += 1;
    } else if (color[1]==0) {
      color[0] = (color[0]+1)%6;
    }
  } else if (pattern==4) {
    //don't ask me to explain the logic here, it's really complicated
    for (int x=0;x<NUMLEDS;x++) {
      strip2.setPixelColor(x, (((((stripData[x]/10)/2)+1)%2)*(255-onStep*VALUE))+((((stripData[x]%10)/2)+1)%2)*onStep*VALUE, ((((stripData[x]/10)+1)%2)*(255-onStep*VALUE))+(((stripData[x]%10)+1)%2)*onStep*VALUE, ((((stripData[x]/10)-1)/2)*(255-onStep*VALUE))+(((stripData[x]%10)-1)/2)*onStep*VALUE);
    }
    if (onStep==255/VALUE) {
      if (pause==100/DELAY) {
        for (int x=0;x<NUMLEDS;x++) {
          stripData[x] = (stripData[x]%10)*10;
          stripData[x] += random(1,4);
          onStep = 0;
          pause = 1;
        } 
      } else {
        pause += 1;
      }
    } else {
      onStep += 1;
    }
  }
  strip2.show();
  delay(DELAY);
}

void serialEvent() {
  while(Serial.available())
  {
    pattern = (int) Serial.read() - '0';
  }
}
