import Data.List.Split
import Data.Char

main :: IO()
main = do
  contents <- getContents
  let eachCustomer = init (splitOn "\n" contents)
  printResult (controller eachCustomer)

printResult :: [String] -> IO()
printResult [] = return()
printResult (x:y:xs) = do
  putStrLn (x ++ " " ++ y)
  printResult xs

controller :: [String] -> [String]
controller [] = []
controller (x:xs)
  | isDigit (x!!0) = (endAverage (splitOn " " x) 0 0.0) : (endName (splitOn " " x)) : controller xs --Their name is at the end
  | otherwise = (startAverage (splitOn " " x) 0 0.0) : (startName (splitOn " " x)) : controller xs --Their name is at the start

endName :: [String] -> String
endName [x] = x
endName (x:xs)
  | isDigit (x!!0) = endName xs
  | otherwise = x ++ " " ++ (endName xs)

endAverage :: [String] -> Int -> Double -> String
endAverage (x:xs) len total
  | isDigit (x!!0) = endAverage xs (len + 1) ((read x :: Double) + total)
  | otherwise = show (total / (fromIntegral len))

startName :: [String] -> String
startName (x:y:xs)
  | isDigit (y!!0) = x
  | otherwise = x ++ " " ++ (startName (y:xs))

startAverage :: [String] -> Int -> Double -> String
startAverage [] len total= show (total / (fromIntegral len))
startAverage (x:xs) len total
  | isDigit (x!!0) = startAverage xs (len + 1) ((read x :: Double) + total)
  | otherwise = startAverage xs len total
