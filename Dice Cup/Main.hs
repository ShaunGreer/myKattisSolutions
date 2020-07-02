import Data.List.Split

main :: IO()
main = do
  line <- getLine
  let n = (read ((splitOn " " line) !! 0) :: Int)
  let m = (read ((splitOn " " line) !! 1) :: Int)

  if n == m
    then putStrLn (show (n+1))
    else do
      let allSums = [(a+b) | a <- [1..n], b <- [1..m]]
      let result = findLargest (createList allSums)
      printList result

--Functions

findLargest :: [(Int, Int)] -> [Int]
findLargest ((a,b):(c,d):xs)
  | d > b = findLargest ((c,d):xs)
  | d == b = [a] ++ findLargest ((c,d):xs)
  | d < b  = [a]

createList :: [Int] -> [(Int, Int)]
createList [] = []
createList (x:xs) = [(x, getSums (x:xs) x)] ++ createList (removeFrom x (x:xs))

getSums :: [Int] -> Int -> Int
getSums [] n = 0
getSums (x:xs) n
  | n == x = 1 + getSums xs n
  | otherwise = getSums xs n

removeFrom :: Int -> [Int] -> [Int]
removeFrom n [] = []
removeFrom n (x:xs)
  | n == x = removeFrom n xs
  | otherwise = x : removeFrom n xs


printList :: [Int] -> IO()
printList [] = return ()
printList (x:xs) = do
  putStrLn (show x)
  printList xs
