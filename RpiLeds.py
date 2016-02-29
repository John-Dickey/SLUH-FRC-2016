import sys
import time
from networktables import NetworkTable
import serial
import logging
logging.basicConfig(level=logging.DEBUG)

NetworkTable.setIpAddress("roborio-5176-frc.local")
NetworkTable.setClientMode()
NetworkTable.initialize()

ser = serial.Serial('/dev/ttyACM0', 9600)

sd = NetworkTable.getTable("LEDS")
pattern = sd.getAutoUpdateValue('pattern', 0)

while True:
	ser.write(pattern)
	time.sleep(1)