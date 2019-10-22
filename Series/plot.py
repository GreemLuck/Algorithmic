import matplotlib.pyplot as plt
import csv

x = []
slow = []
fast = []

with open('threesum.csv', 'r') as csvfile:
    plots = csv.reader(csvfile, delimiter=',')
    next(plots)
    for row in plots:
        x.append(int(row[0]))
        slow.append(int(row[1]))
        fast.append(int(row[2]))

plt.subplot(211)
plt.plot(x, slow, label="ThreeSum")
plt.plot(x, fast, label="ThreeSumFast")
plt.xlabel('n')
plt.ylabel('ms')
plt.title('ThreeSum Algorithm')

plt.subplot(212)
plt.loglog(x, slow, label="ThreeSum")
plt.loglog(x, fast, label="ThreeSumFast")
plt.xlabel('n')
plt.ylabel('ms')

plt.legend()
plt.show()