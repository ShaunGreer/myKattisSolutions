import Data.List.Split
import Data.List
import Data.Char

main :: IO()
main = do
  contents <- getContents
  let alphabet = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
  let eachPhrase = init(tail(splitOn "\n" contents))
  printAnswer (controller eachPhrase alphabet)

controller :: [String] -> [Char] -> [String]
controller [] _ = []
controller (x:xs) alphabet = (checkPangram x alphabet) : controller xs alphabet

checkPangram :: String -> [Char] -> String
checkPangram [] x
  | length x == 0 = "pangram"
  | otherwise = "missing " ++ (missingLetters x)
checkPangram (x:xs) alphabet = checkPangram xs (delete (toLower x) alphabet)

missingLetters :: [Char] -> String
missingLetters [] = []
missingLetters (x:xs) = x : missingLetters xs

printAnswer :: [String] -> IO()
printAnswer [] = return()
printAnswer (x:xs) = do
  putStrLn (x)
  printAnswer xs
