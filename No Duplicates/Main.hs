import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachWord = splitOn " " ((splitOn "\n" contents) !! 0)
  putStrLn (checkDuplicates eachWord)

checkDuplicates :: [String] -> String
checkDuplicates [] = "yes"
checkDuplicates (x:xs)
  | (matcher x xs) = "no"
  | otherwise = checkDuplicates xs

matcher :: String -> [String] -> Bool
matcher s [] = False
matcher s (x:xs)
  | s == x = True
  | otherwise = matcher s xs
