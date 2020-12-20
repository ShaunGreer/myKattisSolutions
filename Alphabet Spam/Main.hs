import Data.Char
import Text.Printf

main :: IO()
main = do
  contents <- getContents
  let countOfEachType = countOccurences (init contents) 0 0 0 0
  printRatios countOfEachType

countOccurences :: String -> Int -> Int -> Int -> Int -> [Int]
countOccurences [] a b c d = [a,b,c,d,(a+b+c+d)]
countOccurences (x:xs) a b c d
  | (ord x) == 95 = countOccurences xs (a+1) b c d --Whitespace (underscore)
  | (ord x) > 96 && (ord x) < 123 = countOccurences xs a (b+1) c d -- Lowercase
  | (ord x) > 64 && (ord x) < 91 = countOccurences xs a b (c+1) d -- Uppercase
  | otherwise = countOccurences xs a b c (d+1) -- Symbol

printRatios :: [Int] -> IO()
printRatios [x] = return()
printRatios (x:xs) = do
  putStrLn (show ((fromIntegral x) / (fromIntegral (last xs))))
  printRatios xs
