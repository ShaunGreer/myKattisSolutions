import Data.List
import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let result = findBlimps (init (splitOn "\n" contents)) 0
  if length result == 0
    then putStrLn "HE GOT AWAY!"
    else printAnswer result

findBlimps :: [String] -> Int -> [Int]
findBlimps [] _ = []
findBlimps (x:xs) i
  | (isInfixOf "FBI" x) = (i+1) : findBlimps xs (i+1)
  | otherwise = findBlimps xs (i+1)

printAnswer :: [Int] -> IO()
printAnswer [] = return()
printAnswer (x:xs) = do
  putStr ((show x) ++ " ")
  printAnswer xs
