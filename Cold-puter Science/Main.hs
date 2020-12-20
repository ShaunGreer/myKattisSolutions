import Data.List.Split

main::IO()
main = do
  contents <- getContents
  let eachLine = splitOn "\n" contents
  let allTemps = splitOn " " (eachLine !! 1)
  putStrLn (show (belowZero allTemps))

belowZero :: [String] -> Int
belowZero [] = 0
belowZero (x:xs)
  | (read x :: Int) < 0 = 1 + belowZero xs
  | otherwise = belowZero xs
