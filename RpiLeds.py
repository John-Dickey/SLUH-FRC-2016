import sys, time, logging, serial, os
from networktables import NetworkTable
logging.basicConfig(level=logging.DEBUG)

NetworkTable.setIpAddress("roborio-5176-frc.local")
NetworkTable.setClientMode()
NetworkTable.initialize()

ser = serial.Serial('/dev/ttyACM0', 9600)

sd = NetworkTable.getTable("RPI")
pattern = sd.getAutoUpdateValue('pattern', 0)
theMoney = sd.getAutoUpdateValue('doTheRestart?', 0)
while True:
	ser.write(pattern)
	if theMoney == 1:
		os.system("sudo service motion restart")
		sd.putNumber('doTheRestart?', 0)
	time.sleep(1)