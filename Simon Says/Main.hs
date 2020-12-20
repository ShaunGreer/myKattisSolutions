import Data.List.Split (splitOn)

main = do
  contents <- getContents
  printAnswer . simonSays . tail . init $ splitOn "\n" contents

printAnswer :: [String] -> IO()
printAnswer [] = return()
printAnswer (x:xs) = do
  putStrLn (x)
  printAnswer xs

simonSays :: [String] -> [String]
simonSays [] = []
simonSays (x:xs)
  | length (words x) < 3 = "" : simonSays xs
  | ((words x) !! 0) == "simon" && ((words x) !! 1) == "says" = (removeFirst2 (drop 2 (words x))) : simonSays xs
  | otherwise = "" : simonSays xs

removeFirst2 :: [String] -> String
removeFirst2 [x] = x
removeFirst2 (x:xs) = x ++ " " ++ removeFirst2 xs
