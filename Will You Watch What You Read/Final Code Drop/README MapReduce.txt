WillYouWatchWhatYouReadMapperReducer
====================================

WillYouWatchWhatYouRead Mapper and Reducer and pig scripts

keep updated code on 
https://github.com/antoloyola90/WillYouWatchWhatYouRead
https://github.com/antoloyola90/WillYouWatchWhatYouReadMapperReducer

********
Mapper/Reducer 1 - Takes combinedFile and finds which are the top 5 genres to make movies from books
********
Mapper/Reducer 2 - Takes output from Mapper/Reduce 1 and finds which are the top 5 anomalies in each genre to make movies from books
********
Mapper/Reducer 3 - Takes output from Mapper/Reduce 1 and finds which does better in general(Movies or Books)
********
Reducer 4 - Takes output from Mapper/Reduce 1 and finds which does better in the top 5 anomalies(Movies or Books)
********

The PIG commands used have been added in the WillYouWatchWhatYouReadMapperReducer code under PIG folder. 
(This uses Reducer outputs to get the top 5 in each output) 
