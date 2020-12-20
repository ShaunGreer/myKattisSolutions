import Data.List.Split

main :: IO()
main  = do
  contents <- getContents
  let eachNumber = init (splitOn "\n" contents)
  let mod42s = modulo eachNumber
  let dupsRemoved = removeDups mod42s
  putStrLn (show (length dupsRemoved))

modulo :: [String] -> [Int]
modulo [] = []
modulo (x:xs) = ((read x :: Int) `mod` 42) : modulo xs

removeDups :: [Int] -> [Int]
removeDups [] = []
removeDups (x:xs)
  | (x `elem` xs) = removeDups xs
  | otherwise = x : removeDups xs
