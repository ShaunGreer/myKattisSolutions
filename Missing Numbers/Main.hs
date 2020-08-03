import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let recitedNumbers = tail (init (splitOn "\n" contents))
  let result = findMissingNumbers (toIntList recitedNumbers) 1
  if result == []
    then putStrLn ("good job")
    else printMissing result

findMissingNumbers :: [Int] -> Int -> [Int]
findMissingNumbers [] _ = []
findMissingNumbers (x:xs) counter
  | (x == counter) = findMissingNumbers xs (counter + 1)  --They said number
  | otherwise = counter : (findMissingNumbers (x:xs) (counter + 1))

printMissing :: [Int] -> IO()
printMissing [] = return()
printMissing (x:xs) = do
  putStrLn (show x)
  printMissing xs

-- Helper function
toIntList :: [String] -> [Int]
toIntList [] = []
toIntList (x:xs) = (read x :: Int) : toIntList xs
