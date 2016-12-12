#!/usr/bin/python3

import sys

if len(sys.argv) != 3:
    print("Invalid number of arguments")

groundTruth = open(str(sys.argv[1]),"r").readlines()
output = open(str(sys.argv[2]),"r").readlines()

gDict = {}

for gLine in groundTruth:
    gBusiness = gLine.strip().split("'")
    for category in gBusiness[3:]:
        if category != " " and category != "":
            if gBusiness[1] in gDict.keys():
                gDict[gBusiness[1]].append(category)
            else:
                gDict[gBusiness[1]] = [category]

oDict = {}
correct = 0
total = 0

for oLine in output:
    oBusiness = oLine.strip().split("'")
    gTruth = gDict.get(oBusiness[1],[])
    for category in oBusiness[3:]:
        if category in gTruth:
            correct += 1
            break
    total += 1

print("Accuracy : " + str((correct*1.0/total)*100))
