import Data.List.Split(splitOn)

main::IO()
main = do
  contents <- getContents
  let cases = tail (init (splitOn "\n" contents))
  printTimes (newTime cases)

printTimes :: [(Int, Int)] -> IO()
printTimes [] = return()
printTimes ((h,m):rest) = do
  putStrLn ((show h) ++ " " ++ (show m))
  printTimes rest

newTime :: [String] -> [(Int, Int)]
newTime [] = []
newTime (x:xs)
  | (x!!0) == 'B' = (backwards (read ((splitOn " " x)!!1)::Int) (read ((splitOn " " x)!!2)::Int) (read ((splitOn " " x)!!3)::Int)) : newTime xs
  | otherwise = (forwards (read ((splitOn " " x)!!1)::Int) (read ((splitOn " " x)!!2)::Int) (read ((splitOn " " x)!!3)::Int)) : newTime xs

forwards :: Int -> Int -> Int -> (Int, Int)
forwards d h m
  | (d > 60) = if (m +(d - 60)) >= 60
    then if (h + 2) == 24
      then (0, (d - 60) - (60 - m))
      else if (h + 2) == 25
        then (1, (d - 60) - (60 - m))
        else (h + 2, (d - 60) - (60 - m))
    else if (h+1) > 23
      then (0, m + (d - 60))
      else (h + 1, m + (d - 60))
  | (d + m) >= 60 = if (h + 1) > 23
    then (0, d - (60-m))
    else (h + 1, d - (60-m))
  | otherwise = (h, m + d)

backwards :: Int -> Int -> Int -> (Int, Int)
backwards d h m
  | (d > 60) = if (m - (d - 60)) < 0
    then if (h - 2) == (-1)
      then (23, 60 - ((d - 60) - m))
      else if (h - 2) == (-2)
        then (22, 60 - ((d - 60) - m))
        else (h - 2, 60 - ((d - 60) - m))
    else if (h - 1) < 0
      then (23, m - (d - 60))
      else (h - 1, m - (d - 60))
  | (m - d) < 0 = if (h - 1) < 0
    then (23, 60 - (d - m))
    else (h - 1, 60 - (d - m))
  | otherwise = (h, m - d)
