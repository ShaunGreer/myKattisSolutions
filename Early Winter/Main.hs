main :: IO()
main = do
  contents <- getContents
  let contentsAsInts = toIntList $ words contents
  let result = findDays (contentsAsInts !! 1) (drop 2 contentsAsInts) 0
  putStrLn $ result

findDays :: Int -> [Int] -> Int  -> String
findDays _ [] _  = "It had never snowed this early!"
findDays thisYear (previousYear:rest) total
  | (previousYear <= thisYear) = "It hadn't snowed this early in " ++ (show total) ++ " years!"
  | otherwise = findDays thisYear rest (total + 1)

toIntList :: [String] -> [Int]
toIntList = map read
