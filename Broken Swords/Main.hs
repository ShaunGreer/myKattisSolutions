import Data.List.Split

main::IO()
main = do
  contents <- getContents
  let swords = init (tail (splitOn "\n" contents))
  let allParts = countParts (myIntercalate swords) 0 0 0 0 0
  putStrLn (output (allParts !! 0) (allParts !! 1) 0)

output :: Int-> Int -> Int -> String
output tb lr total
  | tb < 2 || lr < 2 = (show total) ++ " " ++ (show tb) ++ " " ++ (show lr)
  | otherwise = output (tb-2) (lr-2) (total + 1)

countParts :: String -> Int -> Int -> Int -> Int -> Int -> [Int]
countParts [] _ t b l r = [(t+b), (l+r)]
countParts (x:xs) i t b l r
  | i == 4 = countParts (x:xs) 0 t b l r
  | x == '0' && i == 0 = countParts xs (i+1) (t+1) b l r
  | x == '0' && i == 1 = countParts xs (i+1) t (b+1) l r
  | x == '0' && i == 2 = countParts xs (i+1) t b (l+1) r
  | x == '0' && i == 3 = countParts xs (i+1) t b l (r+1)
  | otherwise = countParts xs (i+1) t b l r

myIntercalate :: [String] -> String
myIntercalate [] = ""
myIntercalate (x:xs) = x ++ myIntercalate xs
