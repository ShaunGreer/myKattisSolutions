import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachLine = splitOn "\n" contents
  let r = read ((splitOn " " (eachLine !! 0)) !! 0) :: Int
  let n = read ((splitOn " " (eachLine !! 0)) !! 1) :: Int
  let booked = asInts (tail (init eachLine))
  let result = (checkAvailability r 1 booked)
  if result == (-1)
    then putStrLn ("too late")
    else putStrLn (show result)

checkAvailability :: Int -> Int -> [Int] -> Int
checkAvailability r counter booked
  | counter > r = (-1)
  | counter `elem` booked = checkAvailability r (counter + 1) booked
  | otherwise = counter

asInts :: [String] -> [Int]
asInts [] = []
asInts (x:xs) = (read x :: Int) : asInts xs
