main::IO()
main = do
  contents <- getContents
  let input = map readInts . words $ contents
  putStrLn (howManyAttacked ((take 4 input) ++ ([input !! 4]))) -- P
  putStrLn (howManyAttacked ((take 4 input) ++ ([input !! 5]))) -- M
  putStrLn (howManyAttacked ((take 4 input) ++ ([input !! 6]))) -- G

howManyAttacked :: [Int] -> String
howManyAttacked (a:b:c:d:x:empty)
  | (attacked a b x 1 1) && (attacked c d x 1 1) = "both"
  | (attacked a b x 1 1) || (attacked c d x 1 1) = "one"
  | otherwise = "none"

attacked :: Int -> Int -> Int -> Int -> Int -> Bool
attacked a b x counter calmTime
  | counter > x = False
  | counter == x = True
  | calmTime == a = attacked a b x (counter + b + 1) 1
  | otherwise = attacked a b x (counter + 1) (calmTime + 1)

readInts :: String -> Int
readInts = read
