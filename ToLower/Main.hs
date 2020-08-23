import Data.List.Split
import Data.Char

main::IO()
main = do
  contents <- getContents
  let eachLine = init (splitOn "\n" contents)
  let t = read ((splitOn " " (eachLine !! 0)) !! 1) :: Int
  let correct = checkCases (tail eachLine) 1 t False
  putStrLn (show (trueCount correct 0))

trueCount :: [Bool] -> Int -> Int
trueCount [] count = count
trueCount (x:xs) count
  | x == True = trueCount xs (count + 1)
  | otherwise = trueCount xs count

checkCases :: [String] -> Int -> Int -> Bool -> [Bool]
checkCases [] i t failed
  | failed == True = [False]
  | otherwise = [True]
checkCases (x:xs) i t failed
  | (i > t) && (failed == True) = False : (checkCases (x:xs) 1 t False)
  | (i > t) && (failed == False) = True : (checkCases (x:xs) 1 t False)
  | (isAllLower x) == False = checkCases xs (i+1) t True
  | otherwise = checkCases xs (i+1) t failed

isAllLower :: String -> Bool
isAllLower (x:xs) = ((toLower x):xs) == (toLowerString (x:xs))

toLowerString :: String -> String
toLowerString [] = []
toLowerString (x:xs) = (toLower x) : toLowerString xs
