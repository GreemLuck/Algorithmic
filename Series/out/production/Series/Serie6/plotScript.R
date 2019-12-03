setwd("~/Documents/UNIFR/Algorithmic/Series/")
#set working dir
#install.packages("ggplot2")
library(ggplot2)

data <- read.table("test.csv", header=T, sep=",")
qplot(N, Time, data = data, geom = c("point", "line"), color = Algorithm, main = "Normal Scale")
data[1:2] <- lapply(data[1:2], log1p) # x -> log(x+1)
qplot(N, Time, data = data, geom = c("point", "line"), color = Algorithm, main = "Log-Log Scale")

lm(formula = Time ~ N, data = data, subset = data$Algorithm==" CheatSort")
lm(formula = Time ~ N, data = data, subset = data$Algorithm==" Heapsort")
lm(formula = Time ~ N, data = data, subset = data$Algorithm==" MergeInsertSort")
lm(formula = Time ~ N, data = data, subset = data$Algorithm==" MergeSort")
lm(formula = Time ~ N, data = data, subset = data$Algorithm==" QuickSort")
lm(formula = Time ~ N, data = data, subset = data$Algorithm==" QuickSortMedian3")

