import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let contentsAsList = splitOn "\n" contents
  printOutput (isOddOrEven (tail (init contentsAsList)))

isOddOrEven :: [String] -> [(Int, String)]
isOddOrEven [] = []
isOddOrEven (x:xs)
  | (read x :: Int) `mod` 2 == 0 = ((read x ::Int), "even") : isOddOrEven xs
  | otherwise = ((read x :: Int), "odd") : isOddOrEven xs

printOutput :: [(Int, String)] -> IO()
printOutput [] = return ()
printOutput ((a,b):xs) = do
  putStrLn ((show a) ++ " is " ++ b)
  printOutput xs
