import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let contentsAsList = splitOn "\n" contents
  --LINE 1
  let line1 = splitOn " " (contentsAsList !! 0)
  let s = (read (line1 !! 0) :: Int)
  let t = (read (line1 !! 1) :: Int)
  --LINE 2
  let line2 = splitOn " " (contentsAsList !! 1)
  --LINE 3
  let line3 = splitOn " " (contentsAsList !! 2)
  --LINE 4
  let line4 = splitOn " " (contentsAsList !! 3)
  let houseToBus = (s + (read (line2 !! 0) :: Int))
  let result = houseToBus + (journeyTime houseToBus 0 line2 line3 line4)
  if result <= t
    then putStrLn ("yes")
    else putStrLn ("no")

journeyTime :: Int -> Int -> [String] -> [String] -> [String] -> Int
journeyTime currentTime counter line2 line3 line4
  | counter == (length line3) = 0
  | otherwise = time + (journeyTime time (counter + 1) line2 line3 line4)
      where
        time = (busTime currentTime (read (line4 !! counter)) :: Int)
          + (read (line3 !! counter) :: Int)
          + (read (line2 !! (counter + 1)) :: Int)


busTime :: Int -> Int -> Int
busTime current interval
  = isIn current [x | x <- [1 .. 1000], x `mod` interval == 0]

isIn :: Int -> [Int] -> Int
isIn a [] = 0
isIn a (x:xs)
  | a == x = 0
  | a < x = x - a
  | otherwise = isIn a xs
