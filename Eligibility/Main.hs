import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachLine = tail (init (splitOn "\n" contents))
  printResults (controller eachLine)

controller :: [String] -> [String]
controller [] = []
controller (x:xs) = findEligibility (splitOn " " x) ++ controller xs

findEligibility :: [String] -> [String]
findEligibility (a:b:c:d:xs)
  | (read ((splitOn "/" b) !! 0) :: Int) >= 2010 = a : "eligible" : []
  | (read ((splitOn "/" c) !! 0) :: Int) >= 1991 = a : "eligible" : []
  | (read d :: Int) >= 41 = a : "ineligible" : []
  | otherwise = a : "coach petitions" : []

printResults :: [String] -> IO()
printResults [] = return()
printResults (x:y:xs) = do
  putStrLn (x ++ " " ++ y)
  printResults xs
